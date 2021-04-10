package cz.majksa.commons.file;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * <p><b>Class {@link cz.majksa.commons.file.File}</b></p>
 * Custom version of {@link java.io.File} that automatically creates the file.
 *
 * @author Majksa
 * @version 1.0.0
 * @see java.io.File
 * @since 1.0.0
 */
public class File extends java.io.File {

    /**
     * Serial version unique id used for serialization
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = -5827982428685783254L;

    /**
     * {@link cz.majksa.commons.file.File} constructor
     *
     * @param pathname the {@link String} path of the file
     * @param create   if the file should be created
     * @throws cz.majksa.commons.file.FileCreationException if <code>create</code> is <code>true</code> and file could not be created for some reason
     */
    public File(@NotNull String pathname, boolean create) throws FileCreationException {
        super(pathname);
        if (create) {
            create();
        }
    }

    /**
     * {@link cz.majksa.commons.file.File} constructor
     *
     * @param parent the {@link java.io.File} parent of this file
     * @param child  the {@link String} path of the file
     * @param create if the file should be created
     * @throws cz.majksa.commons.file.FileCreationException if <code>create</code> is <code>true</code> and file could not be created for some reason
     */
    public File(@NotNull java.io.File parent, @NotNull String child, boolean create) throws FileCreationException {
        super(parent, child);
        if (create) {
            create();
        }
    }

    /**
     * Tries to create the file.
     * If file exists, does nothing.
     *
     * @throws cz.majksa.commons.file.FileCreationException if the file could not be created for some reason
     */
    public void create() throws FileCreationException {
        try {
            if (exists()) {
                return;
            }
            if (!createNewFile()) {
                throw new FileCreationException(this);
            }
        } catch (IOException e) {
            throw new FileCreationException(this, e);
        }
    }
}
