package com.atef.rover.control;

import com.atef.rover.control.Instruction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InstructionTest {

    @Test
    public void create_instruction_from_raw_value() {
        // given
        char l = 'L';
        char r = 'R';
        char m = 'M';

        // when
        Instruction turnLeft = Instruction.valueOf(l);
        Instruction turnRight = Instruction.valueOf(r);
        Instruction move = Instruction.valueOf(m);

        // then
        assertThat(turnLeft).isEqualTo(Instruction.TURN_LEFT);
        assertThat(turnRight).isEqualTo(Instruction.TURN_RIGHT);
        assertThat(move).isEqualTo(Instruction.MOVE);
    }

    @Test
    public void throw_error_if_given_invalid_instruction() {
        // given
        char i = 'I';

        // when

        // then
        assertThatThrownBy(() -> Instruction.valueOf(i))
                .isInstanceOf(IllegalArgumentException.class);
    }
}