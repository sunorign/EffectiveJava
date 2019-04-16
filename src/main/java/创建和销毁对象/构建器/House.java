package 创建和销毁对象.构建器;

public class House {
    private final String door;
    private final String window;
    private final String floor;
    private final String wall;
    private House(Builder builder){
        this.door = builder.door;
        this.window = builder.window;
        this.floor = builder.floor;
        this.wall = builder.wall;
    }
    public static class Builder{
        private String door;
        private String window;
        private String floor;
        private String wall;
        public Builder setDoor(String door){
            this.door = door;
            return this;
        }
        public Builder setWindow(String window){
            this.window = window;
            return this;
        }
        public Builder setFloor(String floor){
            this.floor = floor;
            return this;
        }
        public Builder setWall(String wall){
            this.wall = wall;
            return this;
        }
        public House create(){
            return new House(this);
        }
    }
}
