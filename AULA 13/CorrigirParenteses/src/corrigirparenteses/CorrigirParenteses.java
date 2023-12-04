package corrigirparenteses;

import java.util.*;

/**
 * @since 03/12/2023
 * @author myckazs
 */
public class CorrigirParenteses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        if (verificaBalanceamento(expressao)) {
            System.out.println("A expressão está corretamente balanceada.");
        } else {
            System.out.println("A expressão NÃO está corretamente balanceada.");
        }
    }

    public static boolean verificaBalanceamento(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; // Há um fechamento sem abertura correspondente
                }
                char topo = pilha.pop();
                if ((caractere == ')' && topo != '(')
                        || (caractere == ']' && topo != '[')
                        || (caractere == '}' && topo != '{')) {
                    return false; // Os tipos de parênteses/colchetes/chaves não correspondem
                }
            }
        }

        return pilha.isEmpty(); // Se a pilha estiver vazia, a expressão está balanceada
    }
}
