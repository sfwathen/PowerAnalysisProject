import com.example.poweranalysisproject.Report;

public class ProjectStateSingleton {
    private static final ProjectStateSingleton psSingleton = new ProjectStateSingleton();
    private Report currReport;

    private ProjectStateSingleton() {}

    public static ProjectStateSingleton getInstance() {
        return psSingleton;
    }

}
