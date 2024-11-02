package Staff;

public enum ProgramStatus{
    EXIT,SHOW_INFORMATION_OF_ALL,SHOW_INFORMATION_OF_ONE,UPDATE_STATUS_OF_ONE,INVALID_CHOICE;

    final public static ProgramStatus chooseStatus(int num){
        switch (num) {
            case 0:
                return EXIT;
            case 1:
                return SHOW_INFORMATION_OF_ALL;
            case 2:
                return SHOW_INFORMATION_OF_ONE;
            case 3:
                return UPDATE_STATUS_OF_ONE;
            default:
                return INVALID_CHOICE;
        }
    }
}