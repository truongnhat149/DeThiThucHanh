package services;
import model.TelephoneDirectory;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class DirectoryService implements IDirectoryService {
    List<TelephoneDirectory> directorieList = new ArrayList<>();
    public String path = "data/contacts.csv";

    public DirectoryService() {
        getItem();
    }

    @Override
    public List<TelephoneDirectory> getItem() {
        List<TelephoneDirectory> newDirectory = new ArrayList<>();
        List<String> records = CSVUtils.read(path);
        for (String record : records) {
            newDirectory.add(new TelephoneDirectory(record));
        }
        return directorieList = newDirectory;
    }

    @Override
    public void add(TelephoneDirectory newDirectory) {
        directorieList.add(newDirectory);
        CSVUtils.write(path, directorieList);
    }

    @Override
    public void update() {
        CSVUtils.write(path, directorieList);
    }

    @Override
    public void remove(DirectoryService directoryService) {
        directorieList.remove(directoryService);
        update();
    }

    @Override
    public void search() {

    }

    public boolean isFullNameHaveInList(String fullName) {
        for (TelephoneDirectory directory : directorieList) {
            if (directory.getFullname().equals(fullName)) return true;
        }
        return false;
    }

    public boolean getDirectoryByName(String name) {
        for (TelephoneDirectory directory : directorieList) {
            if (directory.getFullname().contains(name)) {
                return true;
            }
        }
        return false;
    }

}
