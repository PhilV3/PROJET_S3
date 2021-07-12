public class PacketReseau {
    byte spuReseau[] = new byte[200];
    int Identification;
    public PacketReseau(){

    }
    public PacketReseau(int identification){
        Identification = identification;
    }
}
