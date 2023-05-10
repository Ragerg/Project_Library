package kr.ac.kopo;

import kr.ac.kopo.ui.LibraryUI;

public class LibraryMain {

    public static void main(String[] args) {

        try {
            new LibraryUI().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
