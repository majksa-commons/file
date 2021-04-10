package cz.majksa.commons.file;

import org.jetbrains.annotations.NotNull;

/**
 * <p><b>Class {@link cz.majksa.commons.file.Folder}</b></p>
 * Custom version of {@link java.io.File} that automatically creates the folder.
 *
 * @author Majksa
 * @version 1.0.0
 * @see java.io.File
 * @since 1.0.0
 */
public class Folder extends java.io.File {

    /**
     * Serial version unique id used for serialization
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = -8715459952588700735L;

    /**
     * @param pathname the {@link String} path of the file
     * @throws cz.majksa.commons.file.FileCreationException file could not be created for some reason
     */
    public Folder(@NotNull String pathname) throws FolderCreationException {
        super(pathname);
        create();
    }

    /**
     * @param parent the {@link java.io.File} parent of this file
     * @param child  the {@link String} path of the file
     * @throws cz.majksa.commons.file.FolderCreationException folder could not be created for some reason
     */
    public Folder(@NotNull java.io.File parent, @NotNull String child) throws FolderCreationException {
        super(parent, child);
        create();
    }

    /**
     * Gets the {@link cz.majksa.commons.file.Folder} child of this folder.
     *
     * @param name the {@link String} name of the child folder
     * @return the {@link cz.majksa.commons.file.Folder} child
     * @throws cz.majksa.commons.file.FolderCreationException folder could not be created for some reason
     */
    public Folder getFolder(@NotNull String name) throws FolderCreationException {
        return new Folder(this, name);
    }

    /**
     * Gets the {@link cz.majksa.commons.file.File} child of this folder.
     *
     * @param name   the {@link String} name of the child folder
     * @param create if the file should be created
     * @return the {@link cz.majksa.commons.file.Folder} child
     * @throws cz.majksa.commons.file.FileCreationException if the file could not be created for some reason
     */
    public File getFile(@NotNull String name, boolean create) throws FileCreationException {
        return new File(this, name, create);
    }

    /**
     * Tries to create the file.
     * If already exists, does nothing.
     *
     * @throws cz.majksa.commons.file.FolderCreationException if the folder could not be created for some reason
     */
    public void create() throws FolderCreationException {
        if (exists()) {
            return;
        }
        if (!mkdirs()) {
            throw new FolderCreationException(this);
        }
    }
}
