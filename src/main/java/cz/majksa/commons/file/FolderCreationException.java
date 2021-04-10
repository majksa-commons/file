package cz.majksa.commons.file;


import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p><b>Class {@link cz.majksa.commons.file.FolderCreationException}</b></p>
 * Thrown when the folder could not have been created.
 *
 * @author Majksa
 * @version 1.0.0
 * @see RuntimeException
 * @see Exception
 * @see Throwable
 * @since 1.0.0
 */
public class FolderCreationException extends RuntimeException {

    /**
     * Serial version unique id used for serialization
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 2228738067070845331L;

    /**
     * The {@link cz.majksa.commons.file.Folder} that could not have been created.
     */
    @Getter
    protected final Folder folder;

    /**
     * @param folder the {@link cz.majksa.commons.file.Folder} that could not have been created
     */
    public FolderCreationException(@NotNull Folder folder) {
        this(folder, null);
    }

    /**
     * @param folder the {@link cz.majksa.commons.file.Folder} that could not have been created
     * @param cause  the {@link java.lang.Throwable} cause of this exception
     */
    public FolderCreationException(@NotNull Folder folder, @Nullable Throwable cause) {
        super(String.format("Couldn't create file '%s'.", folder.getName()), cause);
        this.folder = folder;
    }

}
