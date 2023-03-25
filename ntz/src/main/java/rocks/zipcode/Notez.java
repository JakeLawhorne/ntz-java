package rocks.zipcode;

import java.util.Scanner;

/**
 * ntz main command.
 */
public final class Notez {
    Scanner scanner = new Scanner(System.in);

    private FileMap filemap;

    public Notez() {
        this.filemap  = new FileMap();
    }

    public Integer getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(Integer noteNumber) {
        this.noteNumber = noteNumber;
    }

    private Integer noteNumber = 1;
    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String argv[]) {
        Scanner scanner = new Scanner(System.in);

        boolean _debug = true;
        // for help in handling the command line flags and data!
        if (_debug) {
            System.err.print("Argv: [");
            for (String a : argv) {
                System.err.print(a+" ");
            }
            System.err.println("]");
        }

        Notez ntzEngine = new Notez();

        ntzEngine.loadDatabase();

        String start = scanner.nextLine();

        if(start.equals("ntz")){
            while(true){
                ntzEngine.printResults();

                System.out.println("[r]emember\n" +
                    "[c]reate new category\n" +
                    "[f]orget a note\n" +
                    "[e]dit a note");

                String userChoice = scanner.nextLine();

                switch (userChoice){
                    case "r": ntzEngine.addNote();
                    break;
                    case "c": ntzEngine.createAppendCategory();
                    break;
                    case "f": ntzEngine.removeNote();
                    break;
                    case "e": ntzEngine.editNote();
                    break;
                    }
                    ntzEngine.saveDatabase();
                }
            }



        /*
         * You will spend a lot of time right here.
         *
         * instead of loadDemoEntries, you will implement a series
         * of method calls that manipulate the Notez engine.
         * See the first one:
         */
//        ntzEngine.loadDemoEntries();

        if (argv.length == 0) { // there are no commandline arguments
            //just print the contents of the filemap.
            ntzEngine.printResults();
        } else {
            if (argv[0].equals("-r")) {
                ntzEngine.addToCategory("General", argv);
            } // this should give you an idea about how to TEST the Notez engine
              // without having to spend lots of time messing with command line arguments.
        }
        /*
         * what other method calls do you need here to implement the other commands??
         */

    }

    private void addToCategory(String string, String[] argv) {
    }

    private void saveDatabase() {
        filemap.save();
    }

    private void loadDatabase() {
        filemap.load();
    }

    public void printResults() {
        System.out.println(this.filemap.toString());
    }

//    public void loadDemoEntries() {
//        filemap.put("General", new NoteList("The Very first Note"));
//        filemap.put("note2", new NoteList("A secret second note"));
//        filemap.put("category3", new NoteList("Did you buy bread AND eggs?"));
//        filemap.put("anotherNote", new NoteList("Hello from ZipCode!"));
//    }
    /*
     * Put all your additional methods that implement commands like forget here...
     */
    public void addNote(){
        System.out.println("Enter your general note:");
        String note = scanner.nextLine();
        filemap.put("General", new NoteList(note));
    }

    public void createAppendCategory(){
    }

    public void removeNote(){

    }
    public void editNote(){

    }
}
