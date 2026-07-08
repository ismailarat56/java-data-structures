public class Main {
    public static void main(String[] args) {
        MyStack actionHistory = new MyStack(5);

        actionHistory.push("Yazı yazıldı");
        actionHistory.push("Silme yapıldı");
        actionHistory.push("Format değiştirildi");
        actionHistory.push("Renk değiştirildi");
        actionHistory.push("Başlık değiştirildi");

        // Dolu stack kontrolü
        actionHistory.push("Paragraf eklendi");

        showLastAction(actionHistory);

        undoAction(actionHistory);
        undoAction(actionHistory);

        System.out.println();
        actionHistory.printStack();

        System.out.println();

        // Boş stack kontrolü
        undoAction(actionHistory);
        undoAction(actionHistory);
        undoAction(actionHistory);
        undoAction(actionHistory);
    }

    static void showLastAction(MyStack actionHistory) {
        String lastAction = actionHistory.peek();

        if (lastAction == null) {
            System.out.println("Son işlem yok.");
        } else {
            System.out.println();
            System.out.println("Son işlem: " + lastAction);
        }
    }

    static void undoAction(MyStack actionHistory) {
        String undoneAction = actionHistory.pop();

        if (undoneAction != null) {
            System.out.println();
            System.out.println("Undo yapıldı: " + undoneAction);

            String newLastAction = actionHistory.peek();

            if (newLastAction == null) {
                System.out.println("Yeni son işlem: none");
            } else {
                System.out.println("Yeni son işlem: " + newLastAction);
            }
        }
    }
}
