package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(int number) {
        this.lottoTickets = createAuto(number);
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> createAuto(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                .map(lottoTicket -> LottoFactory.createAutoLottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<Rank> getRankings(LottoTicket winTicket) {
        return lottoTickets.stream()
                .map(ticket -> ticket.getRanking(winTicket.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lottoTickets.size();
    }


}
