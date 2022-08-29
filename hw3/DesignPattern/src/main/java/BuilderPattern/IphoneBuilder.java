package BuilderPattern;

public class IphoneBuilder extends Builder {

    @Override
    public void buildchip() {  phone.setChip("苹果自研ios芯片"); }

    @Override
    public void buildbackCover() { phone.setBackCover("玻璃后壳"); }

    @Override
    public void buildscreen() {   phone.setScreen("iphone屏幕");  }

    @Override
    public Phone getPhone() {   return phone; }
}