import ca.mcmaster.cas.se2aa4.a2.island.cli.IslandInputHandler;
import ca.mcmaster.cas.se2aa4.a2.island.generator.IslandGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.generator.generators.SettlementGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.hook.Hook;
import ca.mcmaster.cas.se2aa4.a2.island.humidity.soil.SoilAbsorptionProfile;
import ca.mcmaster.cas.se2aa4.a2.island.io.MeshReader;
import ca.mcmaster.cas.se2aa4.a2.island.io.MeshWriter;
import ca.mcmaster.cas.se2aa4.a2.island.mesh.IslandMesh;
import ca.mcmaster.cas.se2aa4.a2.island.mesh.PathBuilder;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.InputHandler;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.exceptions.IllegalInputException;
import node.Node;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            InputHandler handler = IslandInputHandler.getInputHandler(args);

            String input = IslandInputHandler.getInputMesh(handler);
            String output = IslandInputHandler.getOutputFile(handler);
            SoilAbsorptionProfile soilAbsorptionProfile = IslandInputHandler.getSoilAbsorptionProfile(handler);

            MeshReader meshReader = new MeshReader(input);
            IslandMesh mesh = new IslandMesh(meshReader.getMesh(), soilAbsorptionProfile);

            IslandGenerator generator = IslandInputHandler.getIslandMode(handler, mesh);
            generator.generate();


            Hook heatMap = IslandInputHandler.getHook(handler);
            heatMap.apply(mesh.getTiles());

            for(Vertex vertex : mesh.getConverted().getVertices()){
                vertex.setColor(new Color(0,0,0,0));
            }

            SettlementGenerator settlement = new SettlementGenerator();
            List<Node<Vertex>> settlementslist = settlement.generateSettlement(generator.getLand() ,IslandInputHandler.getNumCities(handler), generator.getSeed());


            PathBuilder pathFactory = new PathBuilder();
            pathFactory.build(generator.getLand(), mesh, settlementslist);


            MeshWriter writer = new MeshWriter();
            writer.write(mesh.getConverted(), output);


            System.out.printf("Island Seed: %d\n", generator.getSeed());
        } catch(IllegalInputException e) {
            System.exit(1);
        }
    }
}