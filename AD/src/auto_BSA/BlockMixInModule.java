package auto_BSA;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class BlockMixInModule extends SimpleModule {
	
	public BlockMixInModule() {
		super("BlockMixIn", new Version(0, 0, 1, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Block.class, BlockMixIn.class);
	}

}
