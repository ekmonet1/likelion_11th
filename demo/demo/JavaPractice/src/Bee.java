public abstract class Bee { //abstract = 추상클래스로 지정!
    protected int eyes = 5; //private=접근제어자 4개 중 하나. 부모 class와 연결된 class에서만 쓸 수 있음. public, protected, default
    protected boolean canFly = true;
    protected String food = "Honey";
    protected String name;
    public void setName(String name){
        this.name=name;
    }
    public String getName;

    abstract void introduce();
    abstract void work();
}