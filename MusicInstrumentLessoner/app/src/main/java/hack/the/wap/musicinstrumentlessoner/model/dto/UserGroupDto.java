package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class UserGroupDto implements Serializable{
    private String name;
    private String main;
    private String sub;
    private HashMap<String, TeacherDto> teachers;
    private HashMap<String, UserDto> users;

    public UserGroupDto(String name) {
        this.name = name;
        users = new HashMap<>();
        teachers = new HashMap<>();
    }

    public UserGroupDto(String name, String main, String sub) {
        this.name = name;
        this.main = main;
        this.sub = sub;
        users = new HashMap<>();
        teachers = new HashMap<>();
    }

    public HashMap<String, UserDto> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, UserDto> users) {
        this.users = users;
    }

    public HashMap<String, TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(HashMap<String, TeacherDto> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(TeacherDto dto) {
        teachers.put(dto.getName(), dto);
    }

    public void addUser(UserDto dto) {
        users.put(dto.getName(), dto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "UserGroupDto{" +
                "teachers=" + teachers +
                ", users=" + users +
                '}';
    }
}
