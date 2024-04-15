import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> grades;

    public GradeList(ArrayList<Double> inputList) {
        grades = inputList;
    }

    public GradeList() {
        grades = new ArrayList<>();
    }

    public boolean addGrade(Double grade) {
        return grades.add(grade);
    }

    public Double calculateAverage() throws Exception {
        if (grades.size() == 0) {
            throw new Exception("List of grades is empty");
        }
        Double sum = grades.stream().reduce(0.0, (total, current) -> total + current);
        return sum / grades.size();
    }

    public Double findMax() throws Exception {
        if (grades.size() == 0) {
            throw new Exception("List of grades is empty");
        }
        return grades.stream().reduce(grades.get(0), (max, current) -> current > max ? current : max);
    }

    public Double findMin() throws Exception {
        if (grades.size() == 0) {
            throw new Exception("List of grades is empty");
        }
        return grades.stream().reduce(grades.get(0), (min, current) -> current > min ? min : current);
    }
}
