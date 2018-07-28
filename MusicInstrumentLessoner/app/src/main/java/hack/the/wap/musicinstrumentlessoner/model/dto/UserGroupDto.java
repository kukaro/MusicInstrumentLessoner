package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.util.ArrayList;

public class UserGroupDto {
    private String name;
    private ArrayList<TeacherDto> teachers;
    private ArrayList<UserDto> users;

    public UserGroupDto(String name) {
        this.name = name;
        users = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public ArrayList<UserDto> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDto> users) {
        this.users = users;
    }

    public ArrayList<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(TeacherDto dto) {
        teachers.add(dto);
    }

    public void addUser(UserDto dto) {
        users.add(dto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserGroupDto{" +
                "teachers=" + teachers +
                ", users=" + users +
                '}';
    }
}
