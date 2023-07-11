public class WorkerBee extends Bee implements LazyBee {
    private int eyes = 5;
    private boolean canFly = true;
    private String food = "Honey";
    private String name = "";
    private String job = "Worker";

    @Override
    public void getLazy(){
        System.out.println("꿀을 모으러 가지 않습니다.");
    }
}