package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class BuildItemProcessor implements ItemProcessor<Build, Build> {

    private static final Logger log = LoggerFactory.getLogger(BuildItemProcessor.class);

    @Override
    public Build process(final Build build) throws Exception {
        final String toolbox = build.gettoolbox().toUpperCase();
        final String ctf = build.getctf().toUpperCase();

        final Build transformedBuild = new Build(toolbox, ctf);

        log.info("Converting (" + build + ") into (" + transformedBuild + ")");

        return transformedBuild;
    }

}
