package domain.commend;

import domain.commend.exceptions.StateException;
import domain.pieces.Pieces;

public abstract class NotPlaying extends GameState {
	protected NotPlaying(Pieces pieces) {
		super(pieces);
	}

	@Override
	public State end() {
		throw new StateException("NotPlaying 상태에서 end 명령어는 유효하지 않습니다.");
	}

	@Override
	public State move() {
		throw new StateException("NotPlaying 상태에서 move 명령어는 유효하지 않습니다.");
	}
}
