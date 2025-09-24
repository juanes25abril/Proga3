import java.util.Queue;
import java.util.ArrayDeque;

public class Taller {

    public int ContarVotos(int DownVotes, int UpVotes) {
        Queue<Integer> votosPositivos = new ArrayDeque<>();
        Queue<Integer> votosNegativos = new ArrayDeque<>();
        for (int i = 0; i < UpVotes; i++) {
            votosPositivos.add(1);
        }
        for (int i = 0; i < DownVotes; i++) {
            votosNegativos.add(-1);
        }
        return votosPositivos.size() - votosNegativos.size();
    }


}