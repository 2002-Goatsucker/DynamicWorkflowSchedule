package service.multi;

import controller.impl.NSGAIIPopulationController;
import entity.Chromosome;
import entity.DataPool;
import service.io.Output;
import service.io.impl.ConsoleOutputImpl;
import utils.DataUtils;
import utils.InitUtils;
import utils.WriterUtils;

import java.util.List;
import java.util.Random;

public class MultiPartialReplace {
    public static void main(String[] args) {
        for (int i = 0; i < 30; ++i) {
            DataPool.clear();
            DataPool.random = new Random(i);
            InitUtils.init();
            NSGAIIPopulationController controller = new NSGAIIPopulationController();
            List<List<Chromosome>> list = controller.iterate();
            Output output = new ConsoleOutputImpl();
            output.output(list);
            String str = DataUtils.operateHV(DataPool.all);
            WriterUtils.write("src\\main\\resources\\output\\Partial_Replace_Crash_" + i + ".txt", str);
        }
    }
}
