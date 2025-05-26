package src.recursion.repeatTrial;


import java.util.ArrayList;
import java.util.List;

public class PharseCombination {
    public static void main(String[] args) {
        String[] list1 = {"John", "Emma"};
        String[] list2 = {"plays", "hates"};
        String[] list3 = {"cricket", "badminton"};
//        pharaseGenerator(list1,list2,list3);
        List<String[]> inputList = new ArrayList<>();
        inputList.add(list1);
        inputList.add(list2);
        inputList.add(list3);

        pharaseGeneratorRecursive((ArrayList<String[]>) inputList, new ArrayList<>(), 0);
    }

    private static void pharaseGenerator(String[] list1, String[] list2, String[] list3) {
        for(int i=0;i<list1.length;i++) {
            for(int j=0;j<list2.length;j++) {
                for(int k=0;k<list3.length;k++) {
                    System.out.println(list1[i]+" "+list2[j]+" "+list3[k]);
                }
            }
        }
    }

    private static void pharaseGeneratorRecursive(ArrayList<String[]> inputArrList, ArrayList<String> temp, int index) {
        if (temp.size()==inputArrList.size()) {
            System.out.println(temp);
            return;
        }
        for(int i=0;i<inputArrList.get(index).length;i++) {
            temp.add(inputArrList.get(index)[i]);
            pharaseGeneratorRecursive(inputArrList,temp, index+1);
            temp.remove(temp.size()-1);
        }
    }

//    private static void pharseGeneratorUtil(String[] inputAr, )
}
