package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[1]);
        Engine searchEngine = new Engine();
        searchEngine.sendData(file);
        searchEngine.menu();
    }
}

class Engine {
    private File file;
    private Map<String, List<Integer>> index = new HashMap<>();

    public void menu() throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        boolean engineOn = true;
        while(engineOn) {
            System.out.println("" +
                    "=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit\n");
            String input = read.nextLine();
            switch (input) {
                case "1":
                    executeQuery();
                    break;
                case "2":
                    allData();
                    break;
                case "0":
                    engineOn = false;
                    break;
            }
        }

    }
    public void sendData(File file) throws FileNotFoundException {
        this.file = file;
        Scanner read = new Scanner(file);
        Integer lineNumber = 0;
        while (read.hasNext()){
            indexData(read.nextLine(), lineNumber);
            lineNumber++;
        }
        read.close();
    }
    public void indexData(String data, Integer lineNumber){
        for(String word : data.trim().split(" ")){
            List<Integer> wordOccurs;
            if(this.index.containsKey(word)) {
                wordOccurs = this.index.get(word);
            } else {
                wordOccurs = new ArrayList<>();
            }
            wordOccurs.add(lineNumber);
            this.index.put(word, wordOccurs);
        }
    }

    public List<String> searchData(String query) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        if(!this.index.containsKey(query)){
            return result;
        }
        for(Integer lineIndex : this.index.get(query)){
            result.add(getDataLine(lineIndex));
        }
        return result;
    }

    public String getDataLine(Integer lineIndex) throws FileNotFoundException {
        Scanner read = new Scanner(this.file);
        for(Integer line = 0; line != lineIndex; line++){
            read.nextLine();
        }
        String dataLine = read.nextLine();
        read.close();
        return dataLine;
    }

    public void printAllData() throws FileNotFoundException {
        Scanner read = new Scanner(this.file);
        while(read.hasNext()){
            System.out.println(read.nextLine());
        }
        read.close();
    }

    public boolean isQueryMatch(String data, String query){
        return data.toLowerCase().contains(query.toLowerCase());
    }

    public void executeQuery(String query) throws FileNotFoundException {
        List<String> result = searchData(query);
        if (result.isEmpty()) {
            System.out.println("No matching people found.");
        }else {
            System.out.println(result.size() + " persons found:");
            for(String people : result){
                System.out.println(people);
            }
        }
    }

    public void executeQuery() throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        String query = read.next();
        executeQuery(query);
    }

    public void allData() throws FileNotFoundException {
        printAllData();
    }
}