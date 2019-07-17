package org.springframework.luozlspringtest.springsource.spring08;

import org.springframework.beans.factory.FactoryBean;

public class StudentFactoryBean implements FactoryBean<Student> {

    private String studentInfo;

    @Override
    public Student getObject() throws Exception {
        if (this.studentInfo == null) {
            throw new IllegalArgumentException("'studentInfo' is required");
        }

        // 分割属性
        String[] splitStudentInfo = studentInfo.split(",");
        if (null == splitStudentInfo || splitStudentInfo.length != 3) {
            throw new IllegalArgumentException("'studentInfo' config error");
        }

        // 创建Student并填充属性
        Student student = new Student();
        student.setName(splitStudentInfo[0]);
        student.setAge(Integer.valueOf(splitStudentInfo[1]));
        student.setClassName(splitStudentInfo[2]);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return StudentFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }
}