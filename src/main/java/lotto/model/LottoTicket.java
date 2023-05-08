package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }
}