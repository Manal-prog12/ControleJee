package ma.mihradireda.cinema.controllers;

import lombok.AllArgsConstructor;
import ma.mihradireda.cinema.dto.MatchDto;
import ma.mihradireda.cinema.dto.TicketDto;
import ma.mihradireda.cinema.entities.Match;
import ma.mihradireda.cinema.entities.Ticket;
import ma.mihradireda.cinema.services.MatchService;
import ma.mihradireda.cinema.services.TicketService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQlController {
    MatchService matchService;
    TicketService ticketService;

    @MutationMapping
    Match addMatch(@Argument MatchInput matchInput){
        MatchDto matchDto = new MatchDto();
        matchDto.setReferenceMatch(matchInput.referenceMatch());
        matchDto.setDateMatch(new Date());
        matchDto.setLieuMatch(matchInput.lieuMatch());
        matchDto.setEquipe1(matchInput.equipe1());
        matchDto.setEquipe2(matchInput.equipe2());
        return matchService.ajouterMatch(matchDto);
    }

    @MutationMapping
    Boolean deleteMatch(@Argument Long id){
        return matchService.supprimerMatch(id);
    }

    @MutationMapping
    Ticket addTicket(@Argument TicketInput ticketInput,@Argument Long id){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setReferenceTicket(ticketInput.referenceTicket());
        ticketDto.setPrix(ticketInput.prix());

        return ticketService.ajouterTicket(id,ticketDto);
    }

    @MutationMapping
    Boolean updateTicket(@Argument Long id){
        return ticketService.modifierStatutTicket(id);
    }

    @MutationMapping
    Boolean deletTicket(@Argument Long id){
        return ticketService.supprimerTicket(id);
    }





    record MatchInput(String referenceMatch,String dateMatch,String lieuMatch,String equipe1,String equipe2) {}
    record TicketInput(String referenceTicket,double prix){}
}
