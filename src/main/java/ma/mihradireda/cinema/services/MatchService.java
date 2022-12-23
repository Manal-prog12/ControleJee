package ma.mihradireda.cinema.services;

import lombok.AllArgsConstructor;
import ma.mihradireda.cinema.dto.MatchDto;
import ma.mihradireda.cinema.dto.MatchRefDto;
import ma.mihradireda.cinema.dto.MatchTicketInfoDto;
import ma.mihradireda.cinema.entities.Match;
import ma.mihradireda.cinema.entities.Ticket;
import ma.mihradireda.cinema.repos.MatchRepo;
import ma.mihradireda.cinema.repos.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MatchService implements IMatch{

    MatchRepo matchRepo;
    TicketRepo ticketRepo;

    @Override
    public Match ajouterMatch(MatchDto matchDto) {
        Match match = new Match();
        match.setReferenceMatch(matchDto.getReferenceMatch());
        match.setDateMatch(matchDto.getDateMatch());
        match.setLieuMatch(matchDto.getLieuMatch());
        match.setEquipe1(matchDto.getEquipe1());
        match.setEquipe2(matchDto.getEquipe2());
        matchRepo.save(match);
        System.out.println("Ajout d'un match avec succes");
        return match;
    }



    @Override
    public boolean supprimerMatch(Long id) {
            Match match = matchRepo.findById(id).orElse(null);
            if(match != null){
                matchRepo.delete(match);
                System.out.println("Suppression d'un match avec succes");
                System.out.println("Reference : "+match.getReferenceMatch());
                return true;
            }
            return false;
    }




}
