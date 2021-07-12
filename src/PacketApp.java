import java.nio.charset.StandardCharsets;

public class PacketApp {
    byte spuReseau[] = new byte[1500];
    int numerotation;
    public PacketApp(int numId, String str){
        spuReseau = str.getBytes(StandardCharsets.UTF_8);
        numerotation = numId;
    }
    public PacketReseau[] subDivPacketReseau(){
        int filledSize = 0;
        int i = 0;
        PacketReseau pckR[] = new PacketReseau[8];
        for (int j = 0; j < spuReseau.length; j++) {
            pckR[i].spuReseau[j%200] = spuReseau[j];

            if (j % 200 == 0 && j != 0){
                pckR[i].Identification = i;
                i++;
            }
        }
        return pckR;
    }

}
