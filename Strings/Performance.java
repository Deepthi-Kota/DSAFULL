public class Performance {
    public static void main(String[] args) {
        String series ="";
        for(int i=0; i<26;i++){
            char ch = (char)('a'+i);
            series = series+ch;
        }
        System.out.println(series); //is not very effiecient because new object is created everytime since strings are immutable
        //memory wastage
    }
}
