/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package psemantico;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import psemantico.ExpressoesParser.ProgramaContext;

/**
 *
 * @author ander
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        ExpressoesLexer lexer = new ExpressoesLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressoesParser parser = new ExpressoesParser(tokens);
        ProgramaContext arvore = parser.programa();
        PSemantico c = new PSemantico(args[1]);
        c.visitPrograma(arvore);
        // System.out.println("\nfim");

    }
}



