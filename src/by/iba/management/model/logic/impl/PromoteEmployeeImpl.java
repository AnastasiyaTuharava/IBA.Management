package by.iba.management.model.logic.impl;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Position;
import by.iba.management.model.logic.PromoteEmployee;

public class PromoteEmployeeImpl implements PromoteEmployee {

    @Override
    public Position dev_JtoM_Promo(Employee employee, Employee devMiddlePattern) {
        if (employee.isTeamLead() == (devMiddlePattern.isTeamLead()
                && employee.getPosition().equals(devMiddlePattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(devMiddlePattern.getEnglishLanguageLevel())
                && employee.getProgrammingLanguage().equals(devMiddlePattern.getProgrammingLanguage())
                && employee.getSkills().equals(devMiddlePattern.getSkills())
                && employee.getTools().equals(devMiddlePattern.getTools()))) {
            employee.setPosition(Position.MIDDLE_DEV);
        }
        return Position.MIDDLE_DEV;
    }

    @Override
    public Position dev_MtoS_Promo(Employee employee, Employee devSeniorPattern) {
        if (employee.isTeamLead() == (devSeniorPattern.isTeamLead()
                && employee.getPosition().equals(devSeniorPattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(devSeniorPattern.getEnglishLanguageLevel())
                && employee.getProgrammingLanguage().equals(devSeniorPattern.getProgrammingLanguage())
                && employee.getSkills().equals(devSeniorPattern.getSkills())
                && employee.getTools().equals(devSeniorPattern.getTools()))) {
            employee.setPosition(Position.SENIOR_DEV);
        }
        return Position.SENIOR_DEV;
    }

    @Override
    public Position dev_StoL_Promo(Employee employee, Employee devLeadPattern) {
        if (employee.isTeamLead() == (devLeadPattern.isTeamLead()
                && employee.getPosition().equals(devLeadPattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(devLeadPattern.getEnglishLanguageLevel())
                && employee.getProgrammingLanguage().equals(devLeadPattern.getProgrammingLanguage())
                && employee.getSkills().equals(devLeadPattern.getSkills())
                && employee.getTools().equals(devLeadPattern.getTools()))) {
            employee.setPosition(Position.LEAD_DEV);
        }
        return Position.LEAD_DEV;
    }

    @Override
    public Position qa_JtoM_Promo(Employee employee, Employee qaMiddlePattern) {
        if (employee.isTeamLead() == (qaMiddlePattern.isTeamLead()
                && employee.getPosition().equals(qaMiddlePattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(qaMiddlePattern.getEnglishLanguageLevel())
                && employee.getTesting().equals(qaMiddlePattern.getTesting()))) {
            employee.setPosition(Position.MIDDLE_QA);
        }
        return Position.MIDDLE_QA;
    }

    @Override
    public Position qa_MtoS_Promo(Employee employee, Employee qaSeniorPattern) {
        if (employee.isTeamLead() == (qaSeniorPattern.isTeamLead()
                && employee.getPosition().equals(qaSeniorPattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(qaSeniorPattern.getEnglishLanguageLevel())
                && employee.getTesting().equals(qaSeniorPattern.getTesting()))) {
            employee.setPosition(Position.SENIOR_QA);
        }
        return Position.SENIOR_QA;
    }

    @Override
    public Position qa_StoL_Promo(Employee employee, Employee qaLeadPattern) {
        if (employee.isTeamLead() == (qaLeadPattern.isTeamLead()
                && employee.getPosition().equals(qaLeadPattern.getPosition())
                && employee.getEnglishLanguageLevel().equals(qaLeadPattern.getEnglishLanguageLevel())
                && employee.getTesting().equals(qaLeadPattern.getTesting()))) {
            employee.setPosition(Position.LEAD_QA);
        }
        return Position.LEAD_QA;
    }


}
