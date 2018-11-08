package cn.hlq.common.enmu;

public enum PropertyValue {
    BLACK("黑色",1),
    WHITE("白色",2),
    XSIZE("X",3),
    XLSIZE("XL",4),
    NIKE("NIKE",5),
    ADIDAS("adidas",6);

    private String name;
    private int index;
    private PropertyValue(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for(PropertyValue v:PropertyValue.values()){
            if(v.getIndex()==index){
                return v.name;
            }
        }
        return null;
    }


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
}
