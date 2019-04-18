package 创建和销毁对象;

public class 构建器 {
    public static void main(String[] args) {
        House house = new House.Builder().setDoor("铜门").setWindow("铝合金窗").setFloor("木地板").setWall("大理石墙").create();
        System.out.println(house.toString());
    }
}

class House {
    private final String door;
    private final String window;
    private final String floor;
    private final String wall;

    private House(Builder builder) {
        this.door = builder.door;
        this.window = builder.window;
        this.floor = builder.floor;
        this.wall = builder.wall;
    }

    @Override
    public String toString() {
        return "这房子的" +
                "门是'" + door + '\'' +
                ", 窗户是'" + window + '\'' +
                ", 地板是'" + floor + '\'' +
                ", 墙是'" + wall + '\'' +
                '。';
    }

    public static class Builder {
        private String door;
        private String window;
        private String floor;
        private String wall;

        public Builder setDoor(String door) {
            this.door = door;
            return this;
        }

        public Builder setWindow(String window) {
            this.window = window;
            return this;
        }

        public Builder setFloor(String floor) {
            this.floor = floor;
            return this;
        }

        public Builder setWall(String wall) {
            this.wall = wall;
            return this;
        }

        public House create() {
            return new House(this);
        }
    }
}
