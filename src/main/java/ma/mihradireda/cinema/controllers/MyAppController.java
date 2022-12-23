package ma.mihradireda.cinema.controllers;

import lombok.AllArgsConstructor;
import ma.mihradireda.cinema.dto.MatchDto;
import ma.mihradireda.cinema.dto.MatchTicketInfoDto;
import ma.mihradireda.cinema.dto.TicketDto;
import ma.mihradireda.cinema.entities.Match;
import ma.mihradireda.cinema.entities.Ticket;
import ma.mihradireda.cinema.services.MatchService;
import ma.mihradireda.cinema.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(produces = "application/json",path = "controle")
public class MyAppController {
    MatchService matchService;
    TicketService ticketService;


    @PostMapping("/ajouterMatch")
    public Match addMatch(@RequestBody MatchDto matchDto){
        return matchService.ajouterMatch(matchDto);
    }
    @DeleteMapping("/supprmierMatch/{idMatch}")
    public boolean deleteMatch(@PathVariable Long idMatch){
        return matchService.supprimerMatch(idMatch);
    }
    @PostMapping("/ajouterTicket/{idMatch}")
    public Ticket addTicket(@PathVariable Long idMatch, @RequestBody TicketDto ticketDto){return ticketService.ajouterTicket(idMatch, ticketDto);}
    @PutMapping("changementStatutTicket/{idTicket}")
    public boolean updateTicket(@PathVariable Long idTicket){
        return ticketService.modifierStatutTicket(idTicket);
    }
    @DeleteMapping("/supprimerTicket/{idTicket}")
    public boolean deleteTicket(@PathVariable Long idTicket){return ticketService.supprimerTicket(idTicket);}


}
