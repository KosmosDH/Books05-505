package Models;

import java.util.UUID;

public record Book(
        UUID id,
        String author,
        String title,
        int year,
        String additionalInfo
)
{}
