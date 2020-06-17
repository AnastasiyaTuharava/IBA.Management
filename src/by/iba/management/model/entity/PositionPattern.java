package by.iba.management.model.entity;

/**
 * Created by katya on 3/3/2019.
 */
public class PositionPattern {
    Employee qaMiddle = new Employee(false, Position.JUNIOR_QA, EnglishLanguageLevel.B1,
            new Testing(true, false, true, true));
    Employee qaSenior = new Employee(true, Position.MIDDLE_QA, EnglishLanguageLevel.B2,
            new Testing(true, true, true, true));
    Employee qaLead = new Employee(true, Position.SENIOR_QA, EnglishLanguageLevel.C1,
            new Testing(true, true, true, true));

    Employee devMiddle = new Employee(false, Position.JUNIOR_DEV, EnglishLanguageLevel.B1,
            new ProgrammingLanguage(true, true, true, false, false),
            new Skills(true, true, true, false, false),
            new Tools(true, true, true, false));
    Employee devSenior = new Employee(true, Position.MIDDLE_DEV, EnglishLanguageLevel.B2,
            new ProgrammingLanguage(true, true, true, true, false),
            new Skills(true, true, true, true, false),
            new Tools(true, true, true, true));
    Employee devLead = new Employee(true, Position.SENIOR_DEV, EnglishLanguageLevel.C1,
            new ProgrammingLanguage(true, true, true, true, true),
            new Skills(true, true, true, true, true),
            new Tools(true, true, true, true));

}
