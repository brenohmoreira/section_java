package entities;

public class Room {
    private int numberRoom;
    private String nameOwner;
    private String emailOwner;

    public Room(int numberRoom, String nameOwner, String emailOwner)
    {
        this.numberRoom = numberRoom;
        this.nameOwner = nameOwner;
        this.emailOwner = emailOwner;
    }

    public int numberRoomGet()
    {
        return this.numberRoom;
    }

    public String emailOwnerGet()
    {
        return this.emailOwner;
    }

    public String nameOwnerGet()
    {
        return this.nameOwner;
    }

    public void numberRoomSet(int numberRoom)
    {
        this.numberRoom = numberRoom;
    }

    public void emailOwnerSet(String emailOwner)
    {
        this.emailOwner = emailOwner;
    }

    public void nameOwnerSet(String nameOwner)
    {
        this.nameOwner = nameOwner;
    }

    public String toString()
    {
        return "" + this.numberRoom + ": " + this.nameOwner + ", " + this.emailOwner;
    }
}
