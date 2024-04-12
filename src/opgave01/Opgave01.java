package opgave01;

import opgave01.models.QueueList;

public class Opgave01 {
    public static void main(String[] args) {
        QueueList<String> queue = new QueueList<String>();
        queue.add("Hansel");
        queue.add("Gretel");
        queue.add("Witch");
        queue.add("Hunter");
    }
}
