package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.AgencyModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.view.AgencyView;
import ma.easybanking.main.java.view.EmployeeView;

import java.util.List;
import java.util.Optional;

public class AgencyPresenter {
    private AgencyModel agencyModel;
    private AgencyView agencyView;
    private EmployeeView employeeView;

    public AgencyPresenter(AgencyView agencyView,AgencyModel agencyModel,EmployeeView employeeView){
        this.agencyView = agencyView;
        this.agencyModel = agencyModel;
        this.employeeView = employeeView;
    }

    public void saveAgency(){
        Optional<Agency> optionalAgency = agencyModel.saveAgency(agencyView.saveAgency());
        if(optionalAgency.isPresent()){
            agencyView.displayAgency(optionalAgency.get());
        }else{

        }
    }

    public void deleteAgency(){
        if(agencyModel.deleteAgency(agencyView.getAgency("Suppression d'une agence")))
        {
            agencyView.displaySuccessMsg("Agence supprimée avec succès");
        }else{
            agencyView.displayErrorMsg("Erreur lors de la suppression");
        }
    }

    public void findAgencyByCode(){

        Optional<Agency> agencyOptional = agencyModel.findAgencyByCode(agencyView.getAgency("Checher une Agence"));

        if(agencyOptional.isPresent()){
            agencyView.displayAgency(agencyOptional.get());
        }else{

        }

    }

    public void findAgencyByAddress(){

        List<Agency> agencies = agencyModel.findAgencyByAddress(agencyView.getAgencyAddress("Checher une Agence par Adresse"));

        agencyView.displayAgencies(agencies);

    }

    public void updateAgency(){
        Optional<Agency> optionalAgency = agencyModel.updateAgency(agencyView.updateAgency());
        if(optionalAgency.isPresent()){
            agencyView.displayAgency(optionalAgency.get());
            agencyView.displaySuccessMsg("L'agence a été modifiée avec succès");
        }else{

        }

    }

    public void findAllAgencies(){
        agencyView.displayAgencies(agencyModel.findAllAgencies());
    }

    public void findAgencyByEmpMtrcl(){
        Optional<Agency> optionalAgency = agencyModel.findAgencyByEmpMtrcl(employeeView.getEmployee(""));
        if(optionalAgency.isPresent()){
            agencyView.displayAgency(optionalAgency.get());
        }else{

        }
    }

}
