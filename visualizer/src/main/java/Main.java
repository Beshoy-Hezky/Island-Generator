import ca.mcmaster.cas.se2aa4.a2.io.MeshFactory;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.InputHandler;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.exceptions.IllegalInputException;
import ca.mcmaster.cas.se2aa4.a2.visualizer.GraphicRenderer;
import ca.mcmaster.cas.se2aa4.a2.visualizer.SVGCanvas;
import ca.mcmaster.cas.se2aa4.a2.visualizer.cli.VisualizerInputHandler;
import ca.mcmaster.cas.se2aa4.a2.visualizer.cli.options.DebugOption;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            InputHandler handler = VisualizerInputHandler.getInputHandler(args);

            // Extracting command line parameters
            String input = VisualizerInputHandler.getInputMesh(handler);
            String output = VisualizerInputHandler.getOutputFile(handler);
            // Getting width and height for the canvas
            Structs.Mesh aMesh = new MeshFactory().read(input);

            Mesh mesh = new Mesh(aMesh);

            // Creating the Canvas to draw the mesh
            int[] dimensions = mesh.getDimension();
            int width = dimensions[0];
            int height = dimensions[1];
            Graphics2D canvas = SVGCanvas.build(width, height);

            // Is the visualizer in debug mode?
            boolean isDebug = handler.hasOption(VisualizerInputHandler.getVisualizerOption(DebugOption.OPTION_STR));

            GraphicRenderer renderer = new GraphicRenderer(isDebug);
            // Painting the mesh on the canvas
            renderer.render(mesh, canvas);
            // Storing the result in an SVG file
            SVGCanvas.write(canvas, output);
        } catch(IllegalInputException e) {
            System.exit(1);
        }
    }

}
