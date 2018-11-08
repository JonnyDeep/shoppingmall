package cn.hlq.common.enmu;

public enum PropertyName {
    COLOR("颜色",1),
    SIZE("尺码",2),
    BRAND("品牌",3);

    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private PropertyName(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for(PropertyName n:PropertyName.values()){
            if(n.getIndex()==index){
                return n.name;
            }
        }
        return null;
    }
}
