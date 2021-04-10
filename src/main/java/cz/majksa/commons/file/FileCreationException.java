package cz.majksa.commons.file;

import lombok.Getter;

/**
 * <p><b>Class {@link cz.majksa.commons.file.FileCreationException}</b></p>
 * Thrown when the file could not have been created.
 *
 * @author Majksa
 * @version 1.0.0
 * @see java.lang.RuntimeException
 * @see java.lang.Exception
 * @see java.lang.Throwable
 * @since 1.0.0
 */
public class FileCreationException extends RuntimeException {

    /**
     * Serial version unique id used for serialization
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = -7811951535758973875L;

    /**
     * The {@link cz.majksa.commons.file.File} that could not have been created.
     */
    @Getter
    protected final File file;

    /**
     * @param file the {@link cz.majksa.commons.file.File} that could not have been created
     */
    public FileCreationException(File file) {
        this(file, null);
    }

    /**
     * @param file  the {@link cz.majksa.commons.file.File} that could not have been created
     * @param cause the {@link java.lang.Throwable} cause of this exception
     */
    public FileCreationException(File file, Throwable cause) {
        super(String.format("Couldn't create file '%s'.", file.getName()), cause);
        this.file = file;
    }

}
