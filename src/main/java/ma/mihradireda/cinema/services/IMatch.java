package ma.mihradireda.cinema.services;


import ma.mihradireda.cinema.dto.MatchDto;
import ma.mihradireda.cinema.dto.MatchRefDto;
import ma.mihradireda.cinema.dto.MatchTicketInfoDto;
import ma.mihradireda.cinema.entities.Match;

import java.util.List;

public interface IMatch {
    public Match ajouterMatch(MatchDto matchDto);

    public boolean supprimerMatch(Long id);

}
