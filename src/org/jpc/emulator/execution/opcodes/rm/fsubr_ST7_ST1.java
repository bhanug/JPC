package org.jpc.emulator.execution.opcodes.rm;

import org.jpc.emulator.execution.*;
import org.jpc.emulator.execution.decoder.*;
import org.jpc.emulator.processor.*;
import org.jpc.emulator.processor.fpu64.*;
import static org.jpc.emulator.processor.Processor.*;

public class fsubr_ST7_ST1 extends Executable
{

    public fsubr_ST7_ST1(int blockStart, Instruction parent)
    {
        super(blockStart, parent);
    }

    public Branch execute(Processor cpu)
    {
        double freg0 = cpu.fpu.ST(7);
        double freg1 = cpu.fpu.ST(1);
        if ((freg0 == Double.NEGATIVE_INFINITY && freg1 == Double.NEGATIVE_INFINITY) || (freg0 == Double.POSITIVE_INFINITY && freg1 == Double.POSITIVE_INFINITY)) 
		    cpu.fpu.setInvalidOperation();
        cpu.fpu.setST(7,  freg1-freg0);
        return Branch.None;
    }

    public boolean isBranch()
    {
        return false;
    }

    public String toString()
    {
        return this.getClass().getName();
    }
}