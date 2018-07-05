/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

/**
 *
 * @author Ravi.Nistala
 */
public class tempclass {
   /**
        private void process(PrintStream stream, File zip) throws IOException {
		FileChannel fileChannel = FileChannel.open(f.toPath(), StandardOpenOption.READ);
		FileLock lock = fileChannel.lock(0, Long.MAX_VALUE, true);
		log.debug("Lock acquired: {}", lock.isValid());
		log.debug("Lock is shared: {}", lock.isShared());
		boolean response;
		try (ZipFile zipFile = new ZipFile(zip)) {
			Predicate<ZipEntry> isFile = ze -> !ze.isDirectory();
			Predicate<ZipEntry> isXml = ze -> pattern.matcher(ze.getName()).matches();
			zipFile.stream().filter(isFile).forEach(new Consumer<ZipEntry>() {
				@Override
				public void accept(ZipEntry t) {
					functionalLog.info(" File {}", t.getName());
					if (t.getName().endsWith(".xml")) {
						try {
							log.debug("getting input stream");
							InputStream inputStream = zipFile.getInputStream(t);							
							ISubmissionXmlValidate validateSubmission = new SubmissionXmlValidateImpl();
							log.debug("closing File channel .");
							fileChannel.close();							
							log.debug("invoking validate ");
							
							moveFileToProcessFolder(zip);
							/**
							if (!validateSubmission.validate(XSD_PATH, t.getName(), inputStream)) {
								log.debug("move files to error folder ");
								moveFileToErrorFolder(zip);
																
							}else {								
								log.debug("move files to process folder ");
								moveFileToProcessFolder(zip);
							}
							*/
							/**
						} catch (IOException e) { // TODO Auto-generated catch
							log.error("Error while processing xml file  in {} zip file. Exception is {}.", t.getName(),
									e);
						}
					}else {log.debug(" It is not an xml file.");}
				}
			});

		} catch (IOException e) {
			log.error("Error while opening zip file  in {} zip file. Exception is {}.", f.getName(), e);
		}

		
	}
    */
}
