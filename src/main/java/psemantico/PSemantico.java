/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psemantico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class PSemantico extends ExpressoesBaseVisitor<String>{
    Map<String, String> tabela;
    String args;

    public PSemantico(String args) {
        this.tabela = new HashMap<>();
        this.args = args;
    }

    @Override
    public String visitPrograma(ExpressoesParser.ProgramaContext ctx) {
        // programa: cmd+ EOF;
        ctx.cmd().forEach(cmd -> visitCmd(cmd));
        return null;
    }

    @Override
    public String visitCmd(ExpressoesParser.CmdContext ctx) {
        // ID '<-' expr | 'write' expr;
        String valor = visitExpr(ctx.expr());
        if (ctx.ID() != null) {
            tabela.put(ctx.ID().getText(), valor);
        }
        else {
            //System.out.print(valor);
            FileWriter arq;
            try {
                arq = new FileWriter(args);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf(valor);
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(PSemantico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String visitExpr(ExpressoesParser.ExprContext ctx) {
        // termo (OP termo)*;
        int aux1 = Integer.parseInt(visitTermo(ctx.termo(0)));
        
        if (ctx.termo().size() > 1)
        for (int i = 1; i < ctx.termo().size(); i++) {
            int aux2 = Integer.parseInt(visitTermo(ctx.termo(i)));
            switch (ctx.OP(i-1).getText()) {
                case "+": 
                    aux1 += aux2;
                    break;
                case "-":
                    aux1 -= aux2;
                    break;
                case "*":
                    aux1 *= aux2;
                    break;
            }
        }
        return String.valueOf(aux1);
    }

    @Override
    public String visitTermo(ExpressoesParser.TermoContext ctx) {
        // NUMERO | ID | '(' expr ')';
        if (ctx.NUMERO() != null) return ctx.NUMERO().getText();
        else if (ctx.ID() != null) {
            if (!tabela.containsKey(ctx.ID().getText())){
                //System.out.println("ERRO");
                FileWriter arq;
                try {
                    arq = new FileWriter(args);
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.printf("ERRO");
                    arq.close();
                } catch (IOException ex) {
                    Logger.getLogger(PSemantico.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
                return null;
            }
            else return tabela.get(ctx.ID().getText());
        }
        else return visitExpr(ctx.expr());
    }  
}
