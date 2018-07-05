/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

/**
 *
 * @author Ravi.Nistala
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ArrayTest at = new ArrayTest();

        st[] stArray = new st[3];
        stArray[0] = at.createStudent("name1", "d1");
        stArray[1] = at.createStudent("name2", "d2");
        stArray[2] = at.createStudent("name3", "d1");
        st[] stArray1 = stArray.clone();

        for (int i1 : intArray) {
            System.out.println(i1);
        }

        for (st s1 : stArray1) {
            System.out.println(s1.getName());
            System.out.println(s1.getD().getName());
        }
    }

    private st createStudent(String stname, String depname) {
        st s1 = new st();
        s1.setName(stname);
        dep d1 = new dep();
        d1.setName(depname);
        s1.setD(d1);
        return s1;
    }

    private class st {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public dep getD() {
            return d;
        }

        public void setD(dep d) {
            this.d = d;
        }
        private String name;
        private dep d;
    }

    private class dep {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
