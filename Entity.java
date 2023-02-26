package gamingroom;

class Entity {	

    protected long id;
    protected String name;


    protected Entity() {

    }


    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}