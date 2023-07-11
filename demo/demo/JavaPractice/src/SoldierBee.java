public class SoldierBee extends Bee {

    private String weapon = "";
    private String name;

    public SoldierBee() {}; //생성자. 인스턴스를 생성하는 함수이며 자바에서 자동으로 만들어줌

    public SoldierBee(String name) {
        this.name = name; //this = 만들 객체 각각의 이름 , 뒤의 name은 받은 이름
    };

    @Override
    public void introduce(){
        System.out.println("충성! "+this.name+"입니다.");
    }
}
